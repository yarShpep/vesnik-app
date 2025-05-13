from aiogram import types, Router
from aiogram.filters import Command
from aiogram.types import WebAppInfo, ReplyKeyboardMarkup, KeyboardButton
from services.api_client import get_latest_incidents

__all__ = ["router"]

router = Router()

# Обработчик команды /start
@router.message(Command("start"))
async def cmd_start(message: types.Message):
    web_app = WebAppInfo(url="https://vesnik-frontend.vercel.app")
    keyboard = ReplyKeyboardMarkup(
        keyboard=[[KeyboardButton(text="Открыть Вестник 🧭", web_app=web_app)]],
        resize_keyboard=True
    )
    await message.answer("Добро пожаловать в Вестник происшествий", reply_markup=keyboard)

# Обработчик команды /latest
@router.message(Command("latest"))
async def cmd_latest(message: types.Message):
    incidents = await get_latest_incidents()
    if not incidents:
        await message.answer("Нет новых происшествий.")
        return
    for inc in incidents:
        msg = f"📍 *{inc['category']}*\n{inc['region']}, {inc['station']}\n🕒 {inc['timestamp']}\n✉️ {inc['description']}"
        await message.answer(msg, parse_mode='Markdown')
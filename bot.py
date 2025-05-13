import asyncio
from aiogram import Bot, Dispatcher
from config import BOT_TOKEN
from handlers.incident_handler import router as incident_router

async def main():
    bot = Bot(token=BOT_TOKEN)
    dp = Dispatcher()

    dp.include_router(incident_router)

    await bot.delete_webhook(drop_pending_updates=True)
    print("🚀 Бот запущен. Ожидаю команды...")
    await dp.start_polling(bot)

if __name__ == "__main__":
    asyncio.run(main())
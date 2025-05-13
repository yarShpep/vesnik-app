from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

# Основная клавиатура, отображаемая пользователю
def get_main_keyboard() -> ReplyKeyboardMarkup:
    keyboard = ReplyKeyboardMarkup(
        keyboard=[[KeyboardButton(text="/latest")]],
        resize_keyboard=True
    )
    return keyboard
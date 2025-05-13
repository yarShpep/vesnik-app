import os
from dotenv import load_dotenv

# Загружаем переменные окружения из файла .env
load_dotenv()

# Токен Telegram-бота, ожидается в переменной BOT_TOKEN
BOT_TOKEN = os.getenv("BOT_TOKEN")

# URL API backend-сервера, ожидается в переменной API_URL
# Значение по умолчанию — http://localhost:8080/api
API_URL = os.getenv("API_URL", "http://localhost:8080/api")
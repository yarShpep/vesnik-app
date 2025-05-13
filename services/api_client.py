import aiohttp
import os
from dotenv import load_dotenv
from typing import List, Dict, Any

# Загрузка переменных окружения из файла .env
load_dotenv()

# Базовый URL backend-сервера
API_URL = os.getenv("API_URL", "http://localhost:8080/api")

# Получение списка последних инцидентов с backend API
async def get_latest_incidents() -> List[Dict[str, Any]]:
    try:
        # Создание асинхронной сессии HTTP клиента
        async with aiohttp.ClientSession() as session:
            # Отправка GET-запроса к endpoint инцидентов
            async with session.get(f"{API_URL}/incidents") as resp:
                # Если запрос успешен, возвращаем JSON-ответ
                if resp.status == 200:
                    return await resp.json()
                # В случае другого статуса возвращаем пустой список
                return []
    except aiohttp.ClientError as e:
        # Обработка сетевых ошибок
        print(f"Ошибка при запросе к API: {e}")
        return []
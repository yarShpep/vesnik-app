import os
from dotenv import load_dotenv

load_dotenv()

with open(".env") as f:
    print(f.read())

print("BOT_TOKEN:", os.getenv("BOT_TOKEN"))
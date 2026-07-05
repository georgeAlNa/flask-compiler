import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parent
GENERATED_DIR = ROOT / "generated_components"

sys.path.insert(0, str(GENERATED_DIR))

try:
    from app import app
except ModuleNotFoundError as exc:
    if exc.name == "flask":
        print("[SKIP] Flask is not installed. Run: pip install flask")
        raise SystemExit(0)
    raise


def main():
    client = app.test_client()
    routes = ["/", "/products", "/product/add", "/product/1"]
    allowed_statuses = {200, 302, 404}

    for route in routes:
        response = client.get(route)
        print(f"{route} {response.status_code}")
        if response.status_code not in allowed_statuses:
            raise SystemExit(f"[FAIL] Unexpected status for {route}: {response.status_code}")

    print("[OK] Generated Flask routes responded.")


if __name__ == "__main__":
    main()

import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parent
GENERATED_DIR = ROOT / "generated_components"

sys.path.insert(0, str(GENERATED_DIR))

try:
    from app import app, products_data
except ModuleNotFoundError as exc:
    if exc.name == "flask":
        print("[SKIP] Flask is not installed. Run: pip install flask")
        raise SystemExit(0)
    raise


def main():
    client = app.test_client()
    routes = ["/", "/products", "/product/add", "/product/1", "/product/edit/1"]
    allowed_statuses = {200, 302, 404}

    for route in routes:
        response = client.get(route)
        print(f"{route} {response.status_code}")
        if response.status_code not in allowed_statuses:
            raise SystemExit(f"[FAIL] Unexpected status for {route}: {response.status_code}")

    edit_response = client.post("/product/edit/1", data={
        "name": "Edited Laptop",
        "price": "1300",
        "image": "https://example.com/edited.png",
        "description": "Edited details",
    })
    print(f"/product/edit/1 POST {edit_response.status_code}")
    if edit_response.status_code != 302:
        raise SystemExit(f"[FAIL] Unexpected status for edit POST: {edit_response.status_code}")

    product = next((p for p in products_data if p["id"] == 1), None)
    if not product or product["name"] != "Edited Laptop" or product["details"] != "Edited details":
        raise SystemExit("[FAIL] Edit route did not update product data")

    print("[OK] Generated Flask routes responded.")


if __name__ == "__main__":
    main()

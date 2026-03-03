from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

products_data = [
    {
        "id": 1,
        "name": "Laptop",
        "price": 1200,
        "image": "https://via.placeholder.com/150",
        "details": "Powerful laptop"
    },
    {
        "id": 2,
        "name": "Phone",
        "price": 800,
        "image": "https://via.placeholder.com/150",
        "details": "Smart phone"
    }
]

@app.route('/')
def index():
    allLabel = "All Products"
    addLabel = "Add Product"
    return render_template('Index.html', allLabel=allLabel, addLabel=addLabel)

@app.route('/products')
def products():
    detailsLabel = "View Details"
    items = products_data
    return render_template('Products.html', detailsLabel=detailsLabel, items=items)

@app.route('/product/add', methods=['GET', 'POST'])
def add_product():
    addTitle = "Add New Product"
    saveLabel = "Save Product"
    return render_template('AddProduct.html', addTitle=addTitle, saveLabel=saveLabel)

@app.route('/product/<int:id>')
def product_detail(id):
    product = next((p for p in products_data if p["id"] == id), None)
    backLabel = "Back to Products"
    return render_template('ProductDetail.html', product=product, backLabel=backLabel)


if __name__ == '__main__':
    app.run(debug=True)

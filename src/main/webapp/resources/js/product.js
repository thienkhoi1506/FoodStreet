function deleteProduct(productId) {
    fetch('/streetfood_war_exploded/products/delete/' + productId, {
        method: 'delete',
        headers: {
            'Content-type': 'application/json'
        }
    });
}

function updateProduct(productId) {
    fetch('/streetfood_war_exploded/products/edit/' + productId, {
        method: 'put',
        headers: {
            'Content-type': 'application/json'
        }
    })
}
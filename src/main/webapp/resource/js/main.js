function addToCart(id,name,price){
    event.preventDefault()
    fetch("/streetfood_war_exploded/api/cart",{
        method : 'post',
        body : JSON.stringify({
            "productId":id,
            "productName":name,
            "price":price,
            "count":1
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function(data){
        let counter = document.getElementById("cartCouter")
        counter.innerText = data
    })

}

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
function updateCart(obj,productId){

    fetch("/streetfood_war_exploded/api/cart",{
        method : 'put',
        body : JSON.stringify({
            "productId":productId,
            "productName":"",
            "price":0,
            "count":obj.value
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function(data){
        let counter = document.getElementById("cartCouter")
        counter.innerText = data.counter                          //.counter gọi từ Utils
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount

    })
}
function deleteCart(productId,productName){
    if(confirm(`Bạn có muốn xóa ${productName} hay không ! `)==true){
    fetch(`/streetfood_war_exploded/api/cart/${productId}`,{
        method : 'delete'
    }).then(function(res){
        return res.json()
    }).then(function(data){
        let counter = document.getElementById("cartCouter")
        counter.innerText = data.counter                          //.counter gọi từ Utils
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount                          //.amout gọi từ Utils
        location.reload()
    })
    }
}
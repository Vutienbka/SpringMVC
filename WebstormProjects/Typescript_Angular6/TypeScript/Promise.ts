function sendRequest (myRequest:string){
    return  new Promise((resolve, reject) => {
        setTimeout(resolve,3000);
        if (myRequest==""){
            reject();
        }
    });
}

sendRequest("")
    .then(function (result) {
        console.log("Da gui request");
    })
    .then(function (result) {
        console.log("Da nhan request");
    })
    .then(function (reactChild) {
        console.log("Da save")
    })
    .catch(function () {
        console.log("Xu y that bai")
    });





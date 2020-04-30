function sendRequest(myRequest) {
    return new Promise(function (resolve, reject) {
        setTimeout(resolve, 3000);
        if (myRequest == "") {
            reject();
        }
    });
}
sendRequest("Hello")
    .then(function (){
        console.log("Da gui request");
        return "Xin chao Peter";
    })
    .then(function (result) {
        setTimeout(function () {
            console.log(result);
        },3000);
        console.log("Da nhan request");
        return "Xin chao John";
    })
    .then(function (result) {
        setTimeout(function () {
            console.log(result);
        },2000);
        console.log("Da save");
    })["catch"](function () {
    console.log("Xu ly that bai");
});




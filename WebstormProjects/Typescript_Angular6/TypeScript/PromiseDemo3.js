var add = function (a, b) {
    return new Promise((function (resolve, reject) {
        setTimeout(function () {
            if (typeof a != "number" || typeof b != "number")
                return reject(new Error("Input is not a number"));
            else
                return resolve(a + b);
        }, 2000);
    }));
};
add(4, "5").then(function (value) {
    console.log('result: ' + value);
})["catch"](function (err) {
    console.log('Error: ' + err);
});

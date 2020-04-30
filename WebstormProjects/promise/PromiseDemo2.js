var httpGet = function (url) {
    return new Promise(function (resolve, reject) {
        var request = new XMLHttpRequest();
        request.onload = function () {
            if (this.status === 200) {
                // Success
                return resolve(this.response);
            }
            else {
                // Something went wrong (404 etc.)
                return reject(new Error(this.statusText));
            }
        };
        request.onerror = function () {
            reject(new Error('XMLHttpRequest Error: ' + this.statusText));
        };
        request.open('GET', url);
        request.send();
    });
};

httpGet('https://api.github.com/search/repositories?q=angular').then(function (value) {
    console.log('Contents: ' + value);
}, function (reason) {
    console.error('Something went wrong', reason);
});
// parseJSON
function parseResponse(value) {
    try {
        return JSON.parse(value);
    }
    catch (_) {
        return value;
    }
}
httpGet('https://api.github.com/search/repositories?q=angular')
    .then(parseResponse)
    .then(function (data) { return console.log(data); })
    .catch(function (reason) {
    console.error('Something went wrong', reason);
});
//# sourceMappingURL=PromiseDemo2.js.map

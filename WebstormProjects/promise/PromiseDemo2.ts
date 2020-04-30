let httpGet  = (url: string) => {
    return new Promise(function(resolve, reject) {
        const request = new XMLHttpRequest();
        request.onload = function() {
            if (this.status === 200) {
                // Success
                return resolve(this.response);
            } else {
                // Something went wrong (404 etc.)
                return reject(new Error(this.statusText));
            }
        };
        request.onerror = function() {
            reject(new Error('XMLHttpRequest Error: ' + this.statusText));
        };
        request.open('GET', url);
        request.send();
    });
}

httpGet('https://api.github.com/search/repositories?q=angular').then(
    function(value) {
        console.log('Contents: ' + value);
    },
    function(reason) {
        console.error('Something went wrong', reason);
    }
);
// parseJSON
function parseResponse(value: string) {
    try {
        return JSON.parse(value);
    } catch (_) {
        return value;
    }
}
httpGet('https://api.github.com/search/repositories?q=angular')
    .then(parseResponse)
    .then(data => console.log(data))
    .catch(function(reason) {
        console.error('Something went wrong', reason);
    });

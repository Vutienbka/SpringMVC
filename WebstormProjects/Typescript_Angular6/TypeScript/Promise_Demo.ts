const wait5Secs = new Promise((resolve, reject) => {
    setTimeout(() => {
       return resolve(5);
    }, 5000);
});

wait5Secs.then(data => console.log(data)).catch(err => console.error(err));



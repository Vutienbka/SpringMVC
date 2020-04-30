let add = (a,b) =>{
    return new Promise(((resolve, reject) => {
        setTimeout(()=>{
            if(typeof a !="number" || typeof b!="number")
                return reject(new Error("Input is not a number"));
            else return resolve(a+b);
        },2000)
    }))
}

add(4,"5").then(value => {
    console.log('result: ' + value);
})
    .catch(err=>{
        console.log(err);
    })

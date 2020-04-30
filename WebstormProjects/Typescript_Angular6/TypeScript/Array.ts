const list:number[] = [1,2,3];
const categories:Array<string> = ['Sport','IT','Car'];

console.log(list);
 list.forEach(num => console.log(num.toFixed(2)));

 console.log(categories);
 categories.forEach((str)=>console.log(str.includes('a')));
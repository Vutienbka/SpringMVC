const user = {
    name: 'Bob',
    age: 55
};
for (const key in user) {
    console.log(`${key}: ${user[key]}`);
    //${key} chinh la index hay ten cua phan tu
    //${user[key]} la gia tri ung voi phan tu thu key
}
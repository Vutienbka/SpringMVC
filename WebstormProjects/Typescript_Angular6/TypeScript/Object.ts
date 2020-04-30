interface IArea{
    area(): number;
}

class Shape{
    public x:number;
    public y:number;
    constructor(x:number, y:number) {
        this.x = x;
        this.y = y;
    }

    toString():string{
        return `(x:${this.x}, y: ${this.y})`;
    }
}

class Rect  extends Shape implements IArea{
    public width:number;
    public height:number;
    constructor(x:number, y:number, width:number, height:number) {
        super(x,y);
        this.width = width;
        this.height = height;
    }
    area(): number {
        return this.height * this.width;
    }
}

let rect:Rect = new Rect(5,5,20,20);
console.log(rect.toString());
console.log(rect.area());
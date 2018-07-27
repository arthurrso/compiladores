package main;
import "fmt";

func println(x int) {
    
};

func fib(y, nm int) (x,z int){
    // if ( y > 0 ) {
    //     return y, -y;
    // } else if ( y == 0 )
    // {
    //     return 0, 0;
    // } else {
    //     return -y, y;
    // };

    // println(y);
    // println(nm);

    var a, b, c, i int;
    
    a = 0;
    b = 1;
    c = 1;

    for i = 0; i < y; i = i+1 {
        c = b + a;
        a = b;
        b = c;
    };

    // println(a);
    // println(b);

    return a, b;
};

func main(){
    var pos, neg, dsa, asd,asa, d, sd int;
    pos = 9;

    pos, neg = fib(pos, pos);

    println(pos);
    println(neg);
    // println(dsa);

    // var i, j int;

     // if i == i+1 { i++; break; };
   /* i = 1;

    for i < 5 { i = i+4; break; i--;};       // go's while loop
    
    for  { i = i+9; };
*/
    // var j, k, l, count int;

  /*  for ; l < 12; l = l+1 {

        here:
        for k = 0; k < 10; k = k+1 {
            for i = 0; i < 10; i = i+1 { 

                count = count+1;

                 if ( l < 10 ) {
                    j = j+5;
                };
                 if ( i == k ){
                    j = j+2;
                    continue;
                 } else if ( i < k ){
                    j = j+3;
                 } else if ( i > 2*k ) {
                    j = j+4;
                    continue here;
                 } else{
                    j = j+1;
                 };
                j=j+3;
                
            };
        };
    };*/
   /* i=2;
    {
        {
        i=100;
        };
    };
    i=21;*/
    
}; 
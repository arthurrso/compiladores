package main;
import "fmt";

// j is 4680 at the end

func main(){
    var i int;
     // if i == i+1 { i++; break; };
   /* i = 1;

    for i < 5 { i = i+4; break; i--;};       // go's while loop
    
    for  { i = i+9; };
*/
    var j, k, l int;

    for ; l < 12; l = l+1 {

        here:
        for k = 0; k < 10; k = k+1 {
            for i = 0; i < 10; i = i+1 { 

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
    };
   /* i=2;
    {
        {
        i=100;
        };
    };
    i=21;*/
    
}; 
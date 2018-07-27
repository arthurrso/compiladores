package main;
import "fmt";

func println(x int){

};


func main(){

	var os, a, x int;
	println(os);

	os = 5;

 //   switch os=3; {
	
	// 	case 1: a=7;
	//     case 2: println(os);
	//     default: println(os);
	// };

	switch os < 4 {
		case 1: os = 11;
		case 2: os = 12;
		case 5: println(os);
	    // default: println(os);
	};

	println(os);

	// switch os=3;x<4 {
	// 	case 1: a=7;
	// 	case 2: println(os);
	//     default: println(os);
	// };


	// switch  {
	// 	case 1: a=7;
	// 	case 2: println(os);
	//     default: println(os);
	// };
};

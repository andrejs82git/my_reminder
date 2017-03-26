<?php


function main($num)
{
	$fib = function($n) use (&$fib) 
	{
		return $n<2 ? $n : $fib($n-1) + $fib($n-2);
	};
	return $fib($num);
};

echo main(15);

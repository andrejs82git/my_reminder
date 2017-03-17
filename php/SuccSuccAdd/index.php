<?php
/*
//Function programming example
*/

$Zero = function ($fn) 
{
    return function ($z) 
	{
		return $z;
    	};
};

$Succ = function($op) 
{
    return function ($fn) use ($op) 
	{
		return function ($z) use ($op, $fn) 
			{
				$a1 = $op($fn);
				$a2 = $a1($z);
				return $fn($a2);
			};
	};
};

echo "result must be 3";
echo "\n";
$three = $Succ($Succ($Succ($Zero)));
$funcSend = $three(function ($x) {return $x+1;});
echo( $funcSend(0));
echo "\n";
echo "\n";

echo "result must be 4";
echo "\n";
$multiple = $Succ($Succ($Succ($Succ($Zero))));
$funcMultiple = $multiple(function($x) {return $x - 1;});
echo($funcMultiple(8));
echo "\n";

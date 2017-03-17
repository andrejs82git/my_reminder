<?php

function fact($n)
{
	return $n==false?1:$n*fact($n-1);
}

var_dump(fact(5));


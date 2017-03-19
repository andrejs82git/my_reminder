fact1 0 = 1
fact1 n = fact1(n-1) * n

fact2 n = if n == 0 then 1 else fact2(n-1) * n

fact3 n | n == 0    = 1
	| otherwise = fact3(n-1) * n 

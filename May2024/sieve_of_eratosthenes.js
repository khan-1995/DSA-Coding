
//Task is to print prime numbers upto given N in most optimal way.

// T.c -> O( n ) + O( n * log(log( n )) ) + O( n )
// S.C -> O( n )

function printNPrimes(n){
	let primes = new Array(n+1);
	 
	for(let i=2;i<n;i++){
			if(!primes[i]){
				for(let j=i*i;j<=n;j+=i){
          primes[j] = 1;
        }
			}
  }

	for(let i=2;i<primes.length;i++){
		if(!primes[i]){
			console.log(i);
		}
  }
}

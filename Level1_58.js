function solution(n, k) {
    var answer = 0;
    var convert = n.toString(k);
    var split = convert.split("0")

    for(item of split){
        if(item != '' && item != 1){
            var temp = item
            if(isPrime(temp)){
               answer++
            }
        }
    }
    return answer;
}

function isPrime(num) {
  if(num === 2) {
    return true;
  }
  
  for(let i = 2; i <= Math.floor(Math.sqrt(num)); i++){
    if(num % i === 0){
      return false; 
    }
  }
  return true; 
}

function solution(fees, records) {
    var answer = [];
    var record_map = new Map()
    var record_total = new Map()
    
    for(record of records){
        var record_split = record.split(" ")
        var time = record_split[0].split(":")
        var minutes = time[0] * 60 + Number(time[1])
        
        if(record_split[2] == "IN"){
            record_map.set(record_split[1], minutes)
        } else {
            var use_time = minutes - record_map.get(record_split[1])
            record_map.delete(record_split[1])
            if(record_total.has(record_split[1])){
                var total_time = record_total.get(record_split[1]) + use_time
                record_total.set(record_split[1], total_time)
            } else {
                record_total.set(record_split[1], use_time)
            }
        }
    }
    for(record of record_map){
        var use_time = 1439 - record[1]
        if(record_total.has(record[0])){
            var total_time = record_total.get(record[0]) + use_time
            record_total.set(record[0], total_time)
        } else {
            record_total.set(record[0], use_time)
        }
    }
    
    for(record of record_total){
        if(record[1] <= fees[0]){
            record_total.set(record[0], fees[1])
        } else {
            var total_fee = fees[1] + Math.ceil((record[1] - fees[0]) / fees[2]) * fees[3]
            record_total.set(record[0], total_fee)
        }
    }
    var temp = new Map([...record_total].sort((a, b) => a[0] - b[0]))
    for(item of temp){
        answer.push(item[1])
    }
    return answer;
}

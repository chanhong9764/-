function solution(id_list, report, k) {
    var answer = [];
    let report_count = new Map();
    let report_who = new Map();
    let exist = false;
    let mail_list = [];
    let report_set = new Set(report)
    
    for(let i = 0; i < id_list.length; i++){
        report_count.set(id_list[i], 0);
        report_who.set(id_list[i], "");
        answer.push(0);
    }
    
    for(let item of report_set){
        let reporter = item.split(" ")[0]
        let respondent = item.split(" ")[1]
        
        if(report_who.get(reporter))
        {
            let value = report_who.get(reporter)

            for(let j = 0; j < value.length; j++){
                if(value[j] == respondent){
                    exist = true;
                    break;
                }
            }
        } else {
            let value = [respondent]
            report_who.set(reporter, value)
            exist = true
            report_count.set(respondent,report_count.get(respondent)+1) // 신고받은 횟수 증가
        }
        if(!exist){
            let change_value = report_who.get(reporter)
            change_value.push(respondent)
            report_who.set(reporter,report_who.get(reporter))
            report_count.set(respondent,report_count.get(respondent)+1) // 신고받은 횟수 증가
        }
        exist = false;
    }
    for(let count of report_count.keys()){
        if(report_count.get(count) >= k)
            mail_list.push(count)
    }
    
    for(let i = 0; i < id_list.length; i++){
        let report_people = report_who.get(id_list[i])
        for(let j = 0; j < report_people.length; j++){
            for(let mail of mail_list){
                if(report_people[j] == mail){
                    answer[i]++;
                }
            }   
        }
    }
    
    return answer;
}

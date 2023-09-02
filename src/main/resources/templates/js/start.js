const main=document.querySelector('#main');
const qna=document.querySelector('#qna');
var qIdx=0;
function next(){
    goNext(++qIdx);
}
function prev(){
    if(qIdx==0){
        qna.style.display="none";
        main.style.display="block";
    }
    else{
        goNext(--qIdx);
    }
} 
function goNext(qIdx){
    var q=document.querySelector('.qBox');
    var a1=document.querySelector('.a1');
    var a2=document.querySelector('.a2');
    var a3=document.querySelector('.a3');
    var a4=document.querySelector('.a4');
    var section=document.querySelector('.section');
    var status=document.querySelector('.status');
    var statusBar=document.querySelector('.statusBar');
    if(qIdx%2==0){
        section.innerHTML='문해력 영역';
    }
    else{
        section.innerHTML='MZ 영역';
    }
    status.innerHTML=qIdx+1+'/15';
    statusBar.style.width=((qIdx+1)/15*100)+'%';
    q.innerHTML=qnaList[qIdx].q;
    a1.innerHTML=qnaList[qIdx].a[0].answer;
    a2.innerHTML=qnaList[qIdx].a[1].answer;
    a3.innerHTML=qnaList[qIdx].a[2].answer;
    a4.innerHTML=qnaList[qIdx].a[3].answer;
}

function begin(){
    main.style.display="none";
    qna.style.display="block";
    goNext(qIdx);
}
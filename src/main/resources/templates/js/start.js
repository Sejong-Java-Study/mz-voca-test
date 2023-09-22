const main=document.querySelector('#main');
const qna=document.querySelector('#qna');
const result=document.querySelector('#result');
const commentary=document.querySelector('#commentary');
const ranking=document.querySelector('#ranking');
const select=[];
const button1 = document.querySelector('.button1');
const button2 = document.querySelector('.button2');
const button3 = document.querySelector('.button3');
const button4 = document.querySelector('.button4');
const answer=[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1];
var qIdx=0;
var score=0;
var mzscore=0;
var Grade;
var Mzgrade;
var Percentile;
var Mzpercentile;
var Stscore;
var Mzstscore;

let selectedButton = null;

button1.addEventListener('click', function() {
    var sec;
    if((qIdx+1)%3){
        sec=0;
    }
    else{
        sec=1;
    }
    if(answer[qIdx]==1){
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 1 , tf: true, section: sec });
    }
    else{
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 1 , tf: false, section: sec});
    }
});

button2.addEventListener('click', function() {
    var sec;
    if((qIdx+1)%3){
        sec=0;
    }
    else{
        sec=1;
    }
    if(answer[qIdx]==2){
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 2 , tf: true, section: sec});
    }
    else{
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 2 , tf: false, section: sec});
    }
});

button3.addEventListener('click', function() {
    var sec;
    if((qIdx+1)%3){
        sec=0;
    }
    else{
        sec=1;
    }
    if(answer[qIdx]==3){
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 3 , tf: true, section: sec});
    }
    else{
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 3 , tf: false, section: sec});
    }
});

button4.addEventListener('click', function() {
    var sec;
    if((qIdx+1)%3){
        sec=0;
    }
    else{
        sec=1;
    }
    if(answer[qIdx]==4){
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 4 , tf: true, section: sec});
    }
    else{
        select.push({ questionNumber: qIdx + 1, selectedAnswer: 4 , tf: false, section: sec});
    }
});

function calResult(){
    var sec;
    if((qIdx+1)%3){
        sec=0;
    }
    else{
        sec=1;
    }
   for(i=0; i<15; i++){
        if(select[i]&&select[i].tf===true){
            if(select[i].section==0){
                score+=10;
            }
            else{
                mzscore+=20;
            }
        }
   }
}
function calGrade(){
    if(score<=10){
        Grade=9;
        Percentile=98;
        Stscore=43;
    }
    else if (score<=20){
        Grade=8;
        Percentile=91;
        Stscore=67;
    }
    else if (score<=30){
        Grade=7;
        Percentile=83;
        Stscore=79;
    }
    else if (score<=40){
        Grade=6;
        Percentile=68;
        Stscore=91;
    }
    else if (score<=50){
        Grade=5;
        Percentile=53;
        Stscore=102;
    }
    else if (score<=60){
        Grade=4;
        Percentile=31;
        Stscore=109;
    }
    else if (score<=70){
        Grade=3;
        Percentile=17;
        Stscore=121;
    }
    else if (score<=80){
        Grade=2;
        Percentile=6;
        Stscore=127;
    }
    else{
        Grade=1;
        Percentile=1;
        Stscore=139;
    }
    if(mzscore<20){
        Mzgrade=9;
        Mzpercentile=99;
        Mzstscore=51;
    }
    else if (mzscore<40){
        Mzgrade=7;
        Mzpercentile=81;
        Mzstscore=76;
    }
    else if (mzscore<60){
        Mzgrade=5;
        Mzpercentile=45;
        Mzstscore=102;
    }
    else if (mzscore<80){
        Mzgrade=3;
        Mzpercentile=13;
        Mzstscore=121;
    }
    else{
        Mzgrade=1;
        Mzpercentile=1;
        Mzstscore=134;
    }
}

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
function goFirst(){
    result.style.display="none";
    main.style.display="block";
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
    var stscore=document.querySelector('.stscore');
    var mzstscore=document.querySelector('.mzstscore');
    var percentile=document.querySelector('.percentile');
    var mzpercentile=document.querySelector('.mzpercentile');
    var grade=document.querySelector('.grade');
    var mzgrade=document.querySelector('.mzgrade');

    const buttons = document.querySelectorAll('.answerbutton');
    buttons.forEach(button => button.style.backgroundColor = '');

    if(qIdx===qnaList.length){
        qna.style.display="none";
        result.style.display="block";
        calResult();
        calGrade();
        grade.innerHTML=Grade;
        mzgrade.innerHTML=Mzgrade;
        stscore.innerHTML=Stscore;
        mzstscore.innerHTML=Mzstscore;
        percentile.innerHTML=Percentile;
        mzpercentile.innerHTML=Mzpercentile;
    }
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
    qIdx=0;
    score=0;
    main.style.display="none";
    qna.style.display="block";
    goNext(qIdx);
}
const qnaContainer= document.getElementById('qnacontainer');
function goCommentary(){
    qnaList.forEach((qna,Index)=>{
        addQnA(qna,Index);
    });
    result.style.display="none";
    commentary.style.display="block";
}
function addQnA(qna,Index){
    const qElement = document.createElement('div');
    qElement.classList.add('questionstyle');
    qElement.classList.add('m-5');
    qElement.textContent=qna.q;
    qnaContainer.appendChild(qElement);

    qna.a.forEach((answer,index)=>{
        const aElement=document.createElement('div');
        aElement.classList.add('answerstyle');
        aElement.classList.add('col-8');
        aElement.classList.add('mx-auto');
        aElement.textContent = `${index + 1}. ${answer.answer}`;
        qnaContainer.appendChild(aElement);
    });
    
    const sElement=document.createElement('div');
    sElement.classList.add('commentarystyle');
    sElement.classList.add('m-5');
    if (select[Index] && typeof select[Index].selectedAnswer !== 'undefined') {
        sElement.textContent='선택한 답: '+select[Index].selectedAnswer;
    } else {
        sElement.textContent ='무응답'; // 또는 다른 기본값 설정
    }
    qnaContainer.appendChild(sElement);

    const cElement=document.createElement('div');
    cElement.classList.add('commentarystyle');
    cElement.classList.add('m-5');
    cElement.textContent=qna.c;
    qnaContainer.appendChild(cElement);

}

function goResult(){
    commentary.style.display="none";
    ranking.style.display="none";
    result.style.display="block";
}
function goRanking(){
    result.style.display="none";
    ranking.style.display="block";
}


// 현재 페이지 URL 가져오기
const currentPageURL = window.location.href;

// 링크 복사 함수
function copyPageLink() {
  const tempInput = document.createElement('input');
  tempInput.value = currentPageURL;
  document.body.appendChild(tempInput);
  tempInput.select();
  document.execCommand('copy');
  document.body.removeChild(tempInput);
}

// 카카오톡 공유 함수
function shareKakao() {
<<<<<<< Updated upstream:src/main/resources/templates/js/start.js
  Kakao.Link.sendDefault({
    objectType: 'feed',
    content: {
      title: '페이지 제목',
      description: '페이지 설명',
      imageUrl: '이미지 URL',
      link: {
        mobileWebUrl: currentPageURL,
        webUrl: currentPageURL,
      },
    },
  });
}
=======
    Kakao.Link.sendDefault({
        objectType: 'feed',
        content: {
            title: '페이지 제목',
            description: '페이지 설명',
            imageUrl: '이미지 URL',
            link: {
                mobileWebUrl: currentPageURL,
                webUrl: currentPageURL,
            },
        },
    });
}


    function handleButtonClick(buttonId) {
      // 모든 버튼의 색상을 원래대로 되돌림
      const buttons = document.querySelectorAll('.answerbutton');
      buttons.forEach(button => button.style.backgroundColor = '');

      if (selectedButton === buttonId) {
        // 같은 버튼을 다시 클릭하면 선택 해제
        selectedButton = null;
      } else {
        // 다른 버튼을 클릭하면 해당 버튼을 빨간색으로 변경하고 선택
        selectedButton = buttonId;
        document.querySelector(`.${buttonId}`).style.backgroundColor = 'red';
      }
    }
>>>>>>> Stashed changes:src/main/resources/static/js/start.js

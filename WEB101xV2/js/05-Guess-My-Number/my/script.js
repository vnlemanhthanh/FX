'use strict';

let score = 0;
let highscore = 0;

let num1 = Math.trunc(Math.random() * 10) + 1;
let num2 = Math.trunc(Math.random() * 10) + 1;
let sum = num1 + num2;

document.querySelector('.num1').textContent = num1;
document.querySelector('.num2').textContent = num2;

const displayMessage = function (message) {
  document.querySelector('.message').textContent = message;
};

document.querySelector('.check').addEventListener('click', function () {
  const guess = Number(document.querySelector('.guess').value);
  console.log(guess, typeof guess);
  console.log(num1, typeof num1);
  console.log(num2, typeof num2);

  // When there is no input
  if (!guess) {
    displayMessage('⛔️ No number!');
    score -= 10;
    document.querySelector('.score').textContent = score;

    // When player wins
  } else if (guess === sum) {
    displayMessage('🎉 Correct Number!');
    score += 10;

    document.querySelector('body').style.backgroundColor = 'blue';

    document.querySelector('.check').style.display = 'none';

    // When guess is wrong
  } else if (guess !== sum) {
    score -= 10;

    if (score > 0) {
      displayMessage(guess > sum ? '📈 Too high!' : '📉 Too low!');
    } else {
      displayMessage('💥 You lost the game!');
    }
  }

  document.querySelector('.score').textContent = score;
  if (score > highscore) {
    highscore = score;
    document.querySelector('.highscore').textContent = highscore;
  }
});

document.querySelector('.again').addEventListener('click', function () {
  document.querySelector('.check').style.display = 'inline';

  num1 = Math.trunc(Math.random() * 10) + 1;
  num2 = Math.trunc(Math.random() * 10) + 1;
  sum = num1 + num2;

  displayMessage('Start ...');
  document.querySelector('.num1').textContent = num1;
  document.querySelector('.num2').textContent = num2;
  document.querySelector('.guess').value = '';

  document.querySelector('body').style.backgroundColor = '#222';
});

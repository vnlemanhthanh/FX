SELECT Submissions.hacker_id, Hackers.name --, COUNT(Submissions.hacker_id)
FROM Hackers
JOIN Submissions
    ON Hackers.hacker_id = Submissions.hacker_id
JOIN Challenges
    ON Submissions.challenge_id = Challenges.challenge_id
JOIN Difficulty
    ON Challenges.difficulty_level = Difficulty.difficulty_level
WHERE Submissions.score = Difficulty.score 
    --AND Challenges.difficulty_level = Difficulty.difficulty_level
GROUP BY Submissions.hacker_id, Hackers.name
HAVING COUNT(Submissions.hacker_id) > 1
ORDER BY COUNT(Submissions.hacker_id) DESC, Submissions.hacker_id ASC
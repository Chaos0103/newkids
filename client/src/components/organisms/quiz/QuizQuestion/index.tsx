import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Question from 'components/atoms/quiz/Question';
import { WeeklyQuizQuestionRequestApiBody } from 'types/api';
import { DUMMY_WEEKLY_QUIZS } from 'constants/dummyquiz';
import QuizButton from 'components/atoms/common/QuizButton';
import Swal from 'sweetalert2';
import QuizResult from '../QuizResult';
import { QuizQuestionContainer } from './style';

interface IQuizQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizQuestion(props: IQuizQuestionProps) {
	const { setStep } = props;
	const [isDone, setIsDone] = useState(false);
	const [question, setQuestion] = useState<WeeklyQuizQuestionRequestApiBody[]>(DUMMY_WEEKLY_QUIZS);
	const [currentIndex, setCurrentIndex] = useState(0);
	const [score, setScore] = useState(0);

	console.log(`${score}개 맞았어요!`);

	const handleClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].answerword;

		if (!isDone) {
			if (selectedAnswer === correctAnswer) {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/Y4p2ln.gif',
					imageHeight: 200,
					title: '축하해요! 정답입니다.',
				}).then(() => {
					setCurrentIndex((prevIndex) => prevIndex + 1);
					setIsDone(true);
					setScore((prevIndex) => prevIndex + 1);
				});
			} else {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/4yzNys.gif',
					imageHeight: 200,
					title: '아쉬워요... 오답입니다.',
				}).then(() => {
					setCurrentIndex((prevIndex) => prevIndex + 1);
					setIsDone(true);
				});
			}
		}
	};

	const nextLevelClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].answerword;

		if (!isDone) {
			if (selectedAnswer === correctAnswer) {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/Y4p2ln.gif',
					imageHeight: 200,
					title: '축하해요! 정답입니다.',
				}).then(() => {
					setStep(3);
					setScore((prevIndex) => prevIndex + 1);
				});
			} else {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/4yzNys.gif',
					imageHeight: 200,
					title: '아쉬워요... 오답입니다.',
				}).then(() => {
					setStep(3);
					setScore((prevIndex) => prevIndex);
				});
			}
		}
	};

	useEffect(() => {
		setQuestion(DUMMY_WEEKLY_QUIZS);
		setIsDone(false);
	});

	return (
		<QuizQuestionContainer>
			<Title effectText={question[currentIndex].no} text="번 문제" />
			<Question text={question[currentIndex].description} />
			<hr className="hr" />
			<div className="quiz-button">
				{currentIndex === 4 ? (
					<>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[0]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[0])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[1]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[1])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[2]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[2])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[3]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[3])}
						/>
					</>
				) : (
					<>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[0]}
							handleClick={() => handleClick(question[currentIndex].contents[0])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[1]}
							handleClick={() => handleClick(question[currentIndex].contents[1])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[2]}
							handleClick={() => handleClick(question[currentIndex].contents[2])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[3]}
							handleClick={() => handleClick(question[currentIndex].contents[3])}
						/>
					</>
				)}
			</div>
			<div className="quiz-result">
				<QuizResult score={score} setScore={setScore} setStep={setStep} />
			</div>
		</QuizQuestionContainer>
	);
}

export default QuizQuestion;

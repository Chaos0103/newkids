import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import VocaLottie from 'components/atoms/lottie/VocaLottie';
import Button from 'components/atoms/common/Button';
import useMovePage from 'hooks/useMovePage';
import { WeeklyQuizQuestionRequestApiBody } from 'types/api';
import { DUMMY_WEEKLY_QUIZS } from 'constants/dummyquiz';
import CheckTextButton from 'components/atoms/common/CheckTextButton';
import { QuizWordsWrapper } from './style';

interface IQuizWordsProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizWords({ setStep }: IQuizWordsProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);
	const [movePage] = useMovePage();
	const [question, setQuestion] = useState<WeeklyQuizQuestionRequestApiBody[]>(DUMMY_WEEKLY_QUIZS);
	// const [clickWord, setClickWord] = useState(false);
	const [checkedWords, setCheckedWords] = useState(Array(question.length).fill(false));

	const wordClick = () => {
		if (!isDone) {
			movePage('/vocabulary');
			setStep(4);
			setNum(1);
			setIsDone(true);
		}
	};

	const indexClick = () => {
		if (!isDone) {
			movePage('/');
			setNum(1);
			setIsDone(true);
		}
	};

	useEffect(() => {
		setQuestion(DUMMY_WEEKLY_QUIZS);
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<QuizWordsWrapper>
			<VocaLottie />
			<Title text="이번 퀴즈에서 배운 단어들이에요" effectText="" />
			<div className="checkbox-wrapper">
				{question.map((que) => (
					<div className="checkbox-text-wrapper" key={que.no}>
						<CheckTextButton
							value={checkedWords[que.no]}
							setValue={(value) => {
								const newCheckedWords = [...checkedWords];
								newCheckedWords[que.no] = value;
								setCheckedWords(newCheckedWords);
							}}
							text={que.answerWord}
							size="xl"
						/>
					</div>
				))}
			</div>
			<h1 className="subtitle">선택된 단어가 단어장에 추가됩니다.</h1>
			<div className="quiz-button-wrapper">
				<Button size="m" radius="m" color="Primary" text="추가하기" handleClick={wordClick} />
				<div className="quiz-button">
					<Button size="m" radius="m" color="Normal" text="나가기" handleClick={indexClick} />
				</div>
			</div>
		</QuizWordsWrapper>
	);
}

export default QuizWords;

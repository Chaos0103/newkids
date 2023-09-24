import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import QuizSubImage from 'components/atoms/quiz/QuizSubImage';
import CheckBox from 'components/atoms/common/CheckBox';
import Button from 'components/atoms/common/Button';
import useMovePage from 'hooks/useMovePage';
import { QuizWordsWrapper } from './style';

interface IQuizWordsProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizWords({ setStep }: IQuizWordsProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);
	const [movePage] = useMovePage();

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
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<QuizWordsWrapper>
			<QuizSubImage />
			<Title text="이번 퀴즈에서 배운 단어들이에요" effectText="" />
			<div className="checkbox-wrapper">
				<CheckBox text="갤럭시" />
				<CheckBox text="경상수지" />
				<CheckBox text="인공지능" />
				<CheckBox text="챗GPT" />
				<CheckBox text="벽간소음" />
			</div>
			<h1 className="subtitle">선택된 단어가 단어장에 추가됩니다.</h1>
			<div className="quiz-button">
				<Button size="s" radius="m" color="SubFirst" text="추가하기" handleClick={wordClick} />
				<Button size="s" radius="m" color="Normal" text="나가기" handleClick={indexClick} />
			</div>
		</QuizWordsWrapper>
	);
}

export default QuizWords;

import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';
import { WeeklyQuizQuestionRequestApiBody } from 'types/api';
import { DUMMY_WEEKLY_QUIZS } from 'constants/dummyquiz';
import QuizButton from '../QuizButton';
import { QuizExamplesWrapper } from './style';

function QuizExamples() {
	const [example, setExample] = useState<WeeklyQuizQuestionRequestApiBody[]>(DUMMY_WEEKLY_QUIZS);

	const handleClick = () => {
		Swal.fire({
			imageUrl: 'https://ifh.cc/g/Rkn9J6.jpg',
			imageHeight: 200,
			title: '아 개빡치네',
		}).then(() => {
			console.log('정답입니다.');
		});
	};

	useEffect(() => {
		setExample(DUMMY_WEEKLY_QUIZS);
	});

	const elements = [];
	for (let i = 0; i < example.length; i += 1) {
		const element = example[i];
		elements.push(
			<QuizExamplesWrapper key={i}>
				<QuizButton color="Normal" text={element.contents[0]} handleClick={handleClick} />
				<QuizButton color="Normal" text={element.contents[1]} handleClick={handleClick} />
				<QuizButton color="Normal" text={element.contents[2]} handleClick={handleClick} />
				<QuizButton color="Normal" text={element.contents[3]} handleClick={handleClick} />
			</QuizExamplesWrapper>,
		);
	}
	return elements;

	// return (
	// 	<QuizExamplesWrapper>
	// 		<div>안녕하세요</div>
	// 		<div>안녕하세요2</div>
	// 		<div>안녕하세요3</div>
	// 		<div>안녕하세요4</div>
	// 	</QuizExamplesWrapper>
	// );
}

export default QuizExamples;

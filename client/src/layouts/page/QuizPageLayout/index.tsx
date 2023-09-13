import React, { ReactNode } from 'react';
import { ContentLayout } from 'layouts/common/ContentLayout';
import Button from 'components/atoms/common/Button';
import { QuizPageLayoutContainer } from './style';

interface IQuizPageLayoutProps {
	QuizTitle: ReactNode;
	QuizImage: ReactNode;
	QuizExplain: ReactNode;
}

function QuizPageLayout(props: IQuizPageLayoutProps) {
	const { QuizTitle, QuizImage, QuizExplain } = props;
	return (
		<QuizPageLayoutContainer>
			<ContentLayout>
				<div className="quiz-title">{QuizTitle}</div>
				<div className="quiz-image">{QuizImage}</div>
				<div className="quiz-explain">{QuizExplain}</div>
				<div className="quiz-button">
					<Button size="l" radius="m" color="SubFirst" text="시작하러 가기!" handleClick={() => matchMedia} />
				</div>
			</ContentLayout>
		</QuizPageLayoutContainer>
	);
}

export default QuizPageLayout;

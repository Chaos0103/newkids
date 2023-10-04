import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { QuizPageLayoutContainer } from './style';

interface IQuizPageLayoutProps {
	StepView: ReactNode;
	Footer: ReactNode;
}

function QuizPageLayout(props: IQuizPageLayoutProps) {
	const { StepView, Footer } = props;
	return (
		<QuizPageLayoutContainer>
			<ContentLayout>
				<div className="step-view">{StepView}</div>
			</ContentLayout>
			<FullContentLayout>
				<div className="footer">{Footer}</div>
			</FullContentLayout>
		</QuizPageLayoutContainer>
	);
}

export default QuizPageLayout;

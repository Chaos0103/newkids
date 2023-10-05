import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { GamePageLayoutWrapper } from './style';

interface IGamePageLayoutProps {
	StepView: ReactNode;
	Footer: ReactNode;
}

function GamePageLayout(props: IGamePageLayoutProps) {
	const { StepView, Footer } = props;
	return (
		<GamePageLayoutWrapper>
			<ContentLayout>
				<div className="step-view">{StepView}</div>
			</ContentLayout>
			<FullContentLayout>
				<div className="footer">{Footer}</div>
			</FullContentLayout>
		</GamePageLayoutWrapper>
	);
}

export default GamePageLayout;

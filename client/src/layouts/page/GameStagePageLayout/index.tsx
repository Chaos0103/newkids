import React, { ReactNode } from 'react';
import { GameStagePageLayoutWrapper } from './style';

interface IGameStagePageLayoutProps {
	StageView: ReactNode;
}

function GameStagePageLayout({ StageView }: IGameStagePageLayoutProps) {
	return (
		<GameStagePageLayoutWrapper>
			<div className="stage-view">{StageView}</div>
		</GameStagePageLayoutWrapper>
	);
}

export default GameStagePageLayout;

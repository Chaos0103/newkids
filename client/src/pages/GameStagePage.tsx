import React, { useEffect, useState } from 'react';
import GameQuestion from 'components/organisms/game/GameQuestion';
import GameQuestionTwo from 'components/organisms/game/GameQuestionTwo';
import PageLayout from 'layouts/common/PageLayout';
import GameStagePageLayout from 'layouts/page/GameStagePageLayout';
import GameQuestionThree from 'components/organisms/game/GameQuestionThree';
import GameQuestionFour from 'components/organisms/game/GameQuestionFour';
import GameResult from 'components/organisms/game/GameResult';

function GameStagePage() {
	const [stage, setStage] = useState(0);
	const [step, setStep] = useState(0);
	const [num, setNum] = useState(0);
	const [stageView, setStageView] = useState(<div />);

	console.log(step);

	useEffect(() => {
		switch (stage) {
			case 0: {
				setStageView(<GameQuestion num={num} setNum={setNum} setStep={setStep} setStage={setStage} />);
				break;
			}
			case 1: {
				setStageView(<GameQuestionTwo num={num} setNum={setNum} setStep={setStep} setStage={setStage} />);
				break;
			}
			case 2: {
				setStageView(<GameQuestionThree num={num} setNum={setNum} setStep={setStep} setStage={setStage} />);
				break;
			}
			case 3: {
				setStageView(<GameQuestionFour num={num} setNum={setNum} setStep={setStep} setStage={setStage} />);
				break;
			}
			case 4: {
				setStageView(<GameResult setStep={setStep} />);
				break;
			}
			default: {
				setStageView(<div>에러페이지입니다.</div>);
				break;
			}
		}
	}, [stage]);

	return (
		<PageLayout>
			<GameStagePageLayout StageView={stageView} />
		</PageLayout>
	);
}

export default GameStagePage;

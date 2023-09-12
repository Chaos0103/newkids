import React from 'react';
import Explain from 'components/atoms/quiz/Explain';
import Title from 'components/atoms/quiz/Title';
import PageLayout from 'layouts/common/PageLayout';
import QuizPageLayout from 'layouts/page/QuizPageLayout';
import QuizImage from 'components/atoms/quiz/QuizImage';

function QuizPage() {
	return (
		<PageLayout>
			<QuizPageLayout QuizTitle={<Title />} QuizImage={<QuizImage />} QuizExplain={<Explain />} />
		</PageLayout>
	);
}

export default QuizPage;

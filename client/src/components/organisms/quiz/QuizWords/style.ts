import styled from 'styled-components';

export const QuizWordsWrapper = styled.div`
	min-height: calc(100vh);

	.checkbox-wrapper {
		display: grid;
		justify-content: center;
		align-item: center;
	}

	.checkbox-text-wrapper {
		margin-top: 3rem;
	}

	.subtitle {
		margin-top: 3rem;
		font-size: 2rem;
		display: flex;
		justify-content: center;
		align-item: center;
	}

	.quiz-button-wrapper {
		margin-top: 3rem;
		min-height: 160px;
		display: flex;
		justify-content: center;
		align-item: center;
	}
`;

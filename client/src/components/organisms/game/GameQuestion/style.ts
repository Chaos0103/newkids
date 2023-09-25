import styled from 'styled-components';

export const GameQuestionContainer = styled.div`
	.meaning {
		margin-top: 3rem;
		text-align: left;
		font-size: 2rem;
	}

	.hr {
		margin-top: 1.5rem;
		margin-bottom: 1.5rem;
	}

	.input-wrapper {
		display: flex;
		justify-content: center;
	}

	.input {
		width: 500px;
		height: 40px;
		font-size: 20px;
		border: 0;
		border-radius: 15px;
		outline: none;
		padding-left: 10px;
		background-color: var(--gray-200);
		margin-right: 1.5rem;
	}

	.quiz-button {
		display: flex;
		justify-content: center;
		align-item: center;
		margin-top: 3rem;
	}
`;

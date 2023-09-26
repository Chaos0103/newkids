import styled from 'styled-components';

export const VocabularyButtonWrapper = styled.div`
	.voca-menu {
		display: flex;
		gap: 30px;

		.voca-total-button,
		.voca-know-button {
			width: 150px;
			height: 30px;
			display: flex;
			gap: 30px;
			align-items: center;
			justify-content: space-evenly;
			border: solid 1px var(--gray-200);
			border-radius: var(--radius-l);

			.total-count {
				color: var(--gray-500);
			}

			.know-count {
				color: var(--sub-color-1);
			}
		}
	}
`;

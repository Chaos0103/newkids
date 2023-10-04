import styled from 'styled-components';

export const WordListItemWrapper = styled.div`
	.word-list-item {
		height: 80%;
		display: flex;
		justify-content: space-evenly;
		> svg {
			height: 24px;
			width: 24px;
			fill: var(--danger-color);
		}

		> p {
			flex: 1;
			max-width: 10%;
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
		}
	}
	.item-vocabulary-content:hover {
		cursor: pointer;
	}

	.overlay {
		position: fixed;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		background-color: #fff;
		border: 1px solid #ccc;
		padding: 20px;
		z-index: 9999;
		height: 250px;
		width: 450px;
		border-radius: var(--radius-m);
	}

	.overlay-content {
		display: flex;
		flex-direction: column;
		align-items: center;
		gap: 30px;
		.selected-item-content {
			font-size: 20px;
		}
		.selected-item-description {
			font-size: 20px;
			color: var(--gray-500);
			margin-left: 15px;
			max-height: 100px;
			overflow-y: auto;
		}
	}
`;

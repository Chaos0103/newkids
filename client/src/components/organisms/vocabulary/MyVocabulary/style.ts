import styled from 'styled-components';

export const MyVocabularyContainer = styled.div`
	.notebook-size {
		margin-top: 3rem;
		width: 100%;
		height: 100%;
		height: 700px;
		border-radius: 50px;
		border: 3px solid var(--gray-500);
		position: relative;
		.voca-book {
			margin-top: 7rem;
			width: 100%;
			display: flex;
			.left-page,
			.right-page {
				width: 50%;
				font-size: 20px;
				font-weight: bold;
				.left-title,
				.right-title {
					display: flex;
					justify-content: space-evenly;
				}
				> hr {
					margin-top: 1rem;
					width: 90%;
					border: 1px solid var(--gray-200);
				}
			}
		}
	}

	.ring {
		position: absolute;
		top: -20px;
		left: 50%;
		transform: translateX(-50%) rotate(10deg);
		width: 50px;
		height: 50px;
		background-color: rgba(255, 255, 255, 0);
		border: 5.5px solid var(--gray-200);
		border-radius: 50%;
		border-bottom: 2.5px solid transparent; /* 수정된 부분: border-bottom을 조절하여 부드러운 끝 모양 생성 */
		border-left: 2.5px solid transparent;
		z-index: 1;
	}

	.ring-border {
		position: absolute;
		top: -20px;
		left: 50%;
		transform: translateX(-50%) rotate(10deg);
		width: 50px;
		height: 50px;
		background-color: rgba(255, 255, 255, 0);
		border: 8px solid var(--gray-500);
		border-radius: 50%;
		border-bottom: 2.5px solid transparent; /* 수정된 부분: border-bottom을 조절하여 부드러운 끝 모양 생성 */
		border-left: 2.5px solid transparent;
	}

	.ring-border-1 {
		position: absolute;
		top: -22px;
		left: 45%;
		transform: translateX(-45%) rotate(10deg);
		width: 50px;
		height: 50px;
		background-color: rgba(255, 255, 255, 0);
		border: 8px solid var(--gray-500);
		border-radius: 65%;
		border-bottom: 2.5px solid transparent; /* 수정된 부분: border-bottom을 조절하여 부드러운 끝 모양 생성 */
		border-left: 2.5px solid transparent;
	}

	.small-ring {
		position: absolute;
		width: 15px; /* 작은 원의 너비 설정 */
		height: 15px; /* 작은 원의 높이 설정 */
		background-color: rgba(255, 255, 255, 0.5); /* 작은 원의 배경색 설정 */
		border: 2.5px solid var(--gray-500);
		border-radius: 50%; /* 작은 원을 원 모양으로 만듭니다. */
		bottom: -3px; /* 큰 원 아래에 위치하도록 설정 */
		left: 60%; /* 가운데 정렬 */
		z-index: 1;
		transform: translateX(0%); /* 가운데 정렬 */
	}

	.vertical-line {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translateX(-50%);
		width: 1px; /* 점선의 두께 조절 가능 */
		height: 80%;
		border-left: 1px dashed var(--gray-300); /* 점선 스타일 및 색상 조절 가능 */
		border-right: none;
	}
	.word-list {
		margin-top: 3rem;
		height: 70%;
		display: flex;
		flex-direction: column;
		// justify-content: space-evenly;
		gap: 65px;
	}
	.sort-button {
		position: absolute;
		top: 7%;
		width: 90%;
		text-align: right;
	}
`;

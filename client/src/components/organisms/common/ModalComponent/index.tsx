import React, { ReactNode } from 'react';
import { ModalComponentContainer } from './style';

interface IModalComponentProps {
	children: ReactNode;
	// isOpen: boolean;
	onClose: () => void;
}

function ModalComponent(props: IModalComponentProps) {
	const { children, onClose } = props;
	const closeModal = () => {
		onClose();
	};

	return (
		// <ModalComponentContainer onClick={onClose} isOpen={isOpen}>
		<ModalComponentContainer onClick={closeModal}>
			<button className="modal-body" type="button" onClick={(e) => e.stopPropagation()}>
				{children}
			</button>
		</ModalComponentContainer>
	);
}

export default ModalComponent;

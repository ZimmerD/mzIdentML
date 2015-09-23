package psidev.psi.pi.validator.objectrules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import psidev.psi.tools.ontology_manager.OntologyManager;
import psidev.psi.tools.validator.Context;
import psidev.psi.tools.validator.MessageLevel;
import psidev.psi.tools.validator.ValidatorException;
import psidev.psi.tools.validator.ValidatorMessage;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationResult;

/**
 * Check if there is a unique combination of spectrumID and spectrumRef for each SpectrumIdentificationResult of "final PSM lists".
 * 
 * @author Gerhard
 * 
 */
public class SIRUniqueSpectrumIDSpectrumRefCombinationRule extends AObjectRule<SpectrumIdentificationResult> {

    /**
     * Constants.
     */
    private static final Context SIRContext = new Context(MzIdentMLElement.SpectrumIdentificationResult.getXpath());
    
    /**
     * Members.
     */
    public static boolean bIsFinalPSMList = false;
    HashMap<ImmutablePair, Boolean> spectIDSpectDataRefMap = new HashMap<>();

    /**
     * Constructors.
     */
    public SIRUniqueSpectrumIDSpectrumRefCombinationRule() {
        this(null);
    }

    /**
     * 
     * @param ontologyManager 
     */
    public SIRUniqueSpectrumIDSpectrumRefCombinationRule(OntologyManager ontologyManager) {
        super(ontologyManager);
    }

    /**
     * Checks, if the object is a SpectrumIdentificationResult.
     * 
     * @param obj
     * @return true, if obj is a SpectrumIdentificationResult
     */
    @Override
    public boolean canCheck(Object obj) {
        return (obj instanceof SpectrumIdentificationResult);
    }

    /**
     * Checks, if the combination of spectrumId and spectrumRef is unique for "final PSM lists'
     * 
     * @param sir
     * @return Collection<>
     * @throws ValidatorException 
     */
    @Override
    public Collection<ValidatorMessage> check(SpectrumIdentificationResult sir) throws ValidatorException {
        List<ValidatorMessage> messages = new ArrayList<>();

        if (bIsFinalPSMList) {
            ImmutablePair<String, String> pair = new ImmutablePair<>(sir.getSpectrumID(), sir.getSpectraDataRef());
            
            if (this.spectIDSpectDataRefMap.containsKey(pair)) {
                messages.add(new ValidatorMessage("The combination of spectrumId and spectrumRef of the SpectrumIdentificationResult (id='"
                + sir.getId() + "') element at " + SIRUniqueSpectrumIDSpectrumRefCombinationRule.SIRContext.getContext()
                + "must be unique for 'final PSM lists', ", MessageLevel.ERROR, SIRUniqueSpectrumIDSpectrumRefCombinationRule.SIRContext, this));
            }
            else {
                this.spectIDSpectDataRefMap.put(pair, Boolean.TRUE);
            }
        }
        else {
            this.spectIDSpectDataRefMap.clear();
        }
        
        return messages;
    }

    /**
     * Gets the tips how to fix the error.
     * 
     * @return Collection<>
     */
    @Override
    public Collection<String> getHowToFixTips() {
        List<String> ret = new ArrayList<>();

        ret.add("The combination for each SpectrumIdentificationResult of a 'final PSM list' has to be unique at" + SIRUniqueSpectrumIDSpectrumRefCombinationRule.SIRContext.getContext());

        return ret;
    }
}

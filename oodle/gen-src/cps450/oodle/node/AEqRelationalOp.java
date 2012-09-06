/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AEqRelationalOp extends PRelationalOp
{
    private TEqOp _eqOp_;

    public AEqRelationalOp()
    {
        // Constructor
    }

    public AEqRelationalOp(
        @SuppressWarnings("hiding") TEqOp _eqOp_)
    {
        // Constructor
        setEqOp(_eqOp_);

    }

    @Override
    public Object clone()
    {
        return new AEqRelationalOp(
            cloneNode(this._eqOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqRelationalOp(this);
    }

    public TEqOp getEqOp()
    {
        return this._eqOp_;
    }

    public void setEqOp(TEqOp node)
    {
        if(this._eqOp_ != null)
        {
            this._eqOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eqOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._eqOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._eqOp_ == child)
        {
            this._eqOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._eqOp_ == oldChild)
        {
            setEqOp((TEqOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
